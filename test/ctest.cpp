#include <stdio.h>

typedef unsigned char *byte_pointer;

void show_byte(byte_pointer start, size_t len) {
    size_t i;
    for(int i = 0; i < len; i ++){ 
        printf(" %.2x", start[i]);
    }
    printf("\n");
}

int main() {
    int a = 1879048190;
    show_byte((byte_pointer) &a, sizeof(int));


    printf("强制类型转换 Int->Byte: ");
    unsigned char b = (unsigned char) a;
    printf("%.2x\n", b);

}
