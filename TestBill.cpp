#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define MAX_ITEMS 5
#define DISCOUNT_THRESHOLD 2000000
#define DISCOUNT_RATE 0.25

void generateID(char ID[]) {
    time_t t = time(NULL);
    struct tm tm = *localtime(&t);
    sprintf(ID, "%02d%02d", tm.tm_mday, tm.tm_mon + 1);
}

int kiemTraID(const char *userInput, const char *correctID) {
    return strcmp(userInput, correctID) == 0;
}

struct monAn {
    int mamon[5];
    int soluong[5];
};
typedef struct monAn MA;

typedef struct {
    int ma_mon;
    char ten_mon[100];
    float gia_tien;
} MenuItem;

struct thongtin {
    char ten[30];
    char dienthoai[20];
};
typedef struct thongtin TT;

void nhapThongTinKhachHang(TT *tt) {
    printf("\nMoi nhap ten khach hang: ");
    fflush(stdin);
    fgets(tt->ten, sizeof(tt->ten), stdin);
    tt->ten[strcspn(tt->ten, "\n")] = '\0';
    printf("\nNhap so dien thoai khach hang: ");
    fflush(stdin);
    fgets(tt->dienthoai, sizeof(tt->dienthoai), stdin);
    tt->dienthoai[strcspn(tt->dienthoai, "\n")] = '\0';
}

void inMenu() {
    char *menu;
    menu = (char *)malloc(2500 * sizeof(char));
    FILE *fptr = fopen("menu.txt", "r");
    if (fptr == NULL) {
        printf("Khong the mo duoc file!\n");
        free(menu);
        return;
    } else {
        printf("---------------MENU--------------:\n");
        int ma_mon;
        float gia_tien;
        char ten_mon[100];
        while (fgets(menu, 2500, fptr) != NULL) {
            if (menu[0] != '\n') {
                sscanf(menu, "%d %[^\n] %f\n", &ma_mon, ten_mon, &gia_tien);
                printf(" %d %s %.2f\n", ma_mon, ten_mon, gia_tien);
            }
        }
        printf("---------------------------------\n");
    }
    free(menu);
}

double calculateTotal(MenuItem menu[], int quantities[], int itemCount) {
    double total = 0;
    int i;
    for (i = 0; i < itemCount; i++) {
        total += menu[i].gia_tien * quantities[i];
    }
    return total;
}

void printBill(const char *transactionCode, const char *employeeName, MenuItem menu[], int quantities[], int itemCount) {
    FILE *file = fopen("bill.txt", "w");
    if (file == NULL) {
        printf("Khong the mo file de ghi hoa don.\n");
        exit(1);
    }

    time_t t = time(NULL);
    struct tm tm = *localtime(&t);
    fprintf(file, "Ngay va gio giao dich: %d-%02d-%02d %02d:%02d:%02d\n", tm.tm_year + 1900, tm.tm_mon + 1, tm.tm_mday, tm.tm_hour, tm.tm_min, tm.tm_sec);
    fprintf(file, "Ten nhan vien: %s\n", employeeName);
    fprintf(file, "Bang thong ke san pham:\n");
    fprintf(file, "STT\tSan pham\tSL\tDon gia\t\tThanh tien\n");
    double total = 0;
    int i;
    for (i = 0; i < itemCount; i++) {
        if (quantities[i] > 0) {
            double subtotal = menu[i].gia_tien * quantities[i];
            total += subtotal;
            fprintf(file, "%d\t%s\t\t%d\t%.2lf\t%.2lf\n", i + 1, menu[i].ten_mon, quantities[i], menu[i].gia_tien, subtotal);
        }
    }
    if (total >= DISCOUNT_THRESHOLD) {
        double discountAmount = total * DISCOUNT_RATE;
        double discountedTotal = total - discountAmount;
        fprintf(file, "Tong cong (da giam gia %.2lf%%): %.2lf\n", DISCOUNT_RATE * 100, discountedTotal);
    } else {
        fprintf(file, "Tong cong: %.2lf\n", total);
    }
    fprintf(file, "---------------------------------------\n");
    fclose(file);
}

void inputOrder(MenuItem menu[], int quantities[], int itemCount) {
    int lineCount = 0;
    int blankCount = 0;
    while (lineCount < MAX_ITEMS) {
        int code, quantity;
        char buffer[100];
        fgets(buffer, sizeof(buffer), stdin);
        if (sscanf(buffer, "%d %d", &code, &quantity) != 2) {
            printf("Da xay ra loi khi nhap du lieu.\n");
            break;
        }
        if (code == 0 && quantity == 0) {
            break;
        }
        if (code < 1 || code > itemCount) {
            printf("Ma mon khong hop le.\n");
            continue;
        }
        quantities[code - 1] += quantity;
        lineCount++;
        if (lineCount == MAX_ITEMS) {
            break;
        }
        if (quantity == 0) {
            blankCount++;
            if (blankCount == 9) {
                break;
            }
        } else {
            blankCount = 0;
        }
    }
}
void xemTongHoaDon() {
    char userInput[5];
    char correctID[5];
    generateID(correctID);
    printf("Nhap vao ma giao dich (hoac 'exit' de thoat): ");
    scanf("%s", userInput);
    if (kiemTraID(userInput, correctID)) {
        FILE *file = fopen("bill.txt", "r");
        if (file == NULL) {
            printf("Khong the mo file de doc hoa don.\n");
            return;
        }
        printf("Hoa don trong ngay:\n");
        printf("---------------------------------\n");
        char line[256];
        while (fgets(line, sizeof(line), file) != NULL) {
            printf("%s", line);
        }
        printf("---------------------------------\n");
        fclose(file);
    } else {
        printf("Ma giao dich khong dung. Thu lai sau.\n");
    }
}
void mainmenu() {
    int choice = 0;
    MenuItem menu[MAX_ITEMS];
    TT khachHang;
    int itemCount, quantities[100] = {0};
    char transactionCode[100], employeeName[100];
    while (choice !=0) {
        printf("------------MENU CHUONG TRINH:-------------- \n");
        printf("1. Nhap thong tin khach hang\n");
        printf("2. In menu\n");
        printf("3. Nhap phan khach order\n");
        printf("4. In hoa don\n");
        printf("5. Xem tong hoa don trong ngay\n");
        printf("0. Ket thuc chuong trinh\n");
        printf("-------------------------------------------- \n");
        printf("Vui long nhap su lua chon cua ban:\n");
        scanf("%d", &choice);
        switch (choice) {
        case 1:
            nhapThongTinKhachHang(&khachHang);
            break;
        case 2:
            system("cls");
            inMenu();
            break;
        case 3:
            printf("Chon mon an (nhap ma mon va so luong, nhap 0 0 de ket thuc):\n");
            // inputOrder(quantities, itemCount);
            inputOrder(menu, quantities, itemCount);
            system("cls");
            break;
        case 4:
            printBill(transactionCode, employeeName, menu, quantities, itemCount);
            break;
        case 5:
            xemTongHoaDon();
            break;
        case 0:
            printf("Thoat chuong trinh...\n");
            exit(0);
            break;
        default:
            printf("Lua chon khong hop le. Vui long chon lai.\n");
        }
    }
}
int main() {
    char userInput[5], transactionCode[100], employeeName[100];
    MenuItem menu[MAX_ITEMS];
    TT khachHang;
    int itemCount, quantities[100] = {0}, choice;
    printf("Nhap vao ma giao dich (hoac 'exit' de thoat): ");
    scanf("%s", userInput);
    char correctID[5];
    generateID(correctID);
    if (strcmp(userInput, correctID) == 0) {
        printf("Ma giao dich dung.\n");
        system("cls");
        printf("Nhap ten nhan vien: ");
        scanf("%s", employeeName);
        mainmenu();
    } else {
        printf("Ma giao dich khong dung. Thu lai sau.\n");
    }
    return 0;
}
