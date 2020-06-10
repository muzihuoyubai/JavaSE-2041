#include <stdio.h>

/*
 * 显示菜单的选项，使用数组，同时使用数组的长度来判断用户的输出是否合法
 * 用户输入的数字不能大于数组的长度
 */
char *ROOT_MENU[] = {"要进行哪种运算？\n", "1.加法\n", "2.减法\n", "3.乘法\n", "4.除法\n", "5.退出\n"};

int ROOT_MENU_LEN = sizeof(ROOT_MENU) / sizeof(char *);

// 流程状态枚举
enum FlowStatus {
    ROOT, QUIT, OPT_ONE_INPUT, OPT_TWO_INPUT
};

// 计算类型枚举
enum CalculateType {
    ADD, SUB, MUL, DIV, NONE
};

void displayRootMenu();

int scanInt();

void calculate(enum CalculateType calType, int calNumOne, int calNumTwo);

enum CalculateType getCalType(int userInput);

int main() {
    // 记录第一个操作数
    int calNumOne = 0;
    // 记录第二个操作数
    int calNumTwo = 0;
    // 记录用户输入的菜单选项
    int userInput = 0;
    // 记录当前的流程状态，是显示菜单选项还是用户输入
    enum FlowStatus flowStatus = ROOT;
    // 记录用户选择的计算类型
    enum CalculateType calType = NONE;

    while (flowStatus != QUIT) {
        switch (flowStatus) {
            case ROOT:
                displayRootMenu();
                userInput = scanInt();
                // 用户输入不合法
                if (userInput <= 0 || userInput > ROOT_MENU_LEN) {
                    printf("不存在的选项！\n");
                    // 用户输入的退出项，退出项是菜单数组中的最后一项
                } else if (userInput == ROOT_MENU_LEN - 1) {
                    flowStatus = QUIT;
                } else {
                    calType = getCalType(userInput);
                    flowStatus = OPT_ONE_INPUT;
                }
                break;
            case OPT_ONE_INPUT:
                printf("请输入第一个操作数:");
                calNumOne = scanInt();
                flowStatus = OPT_TWO_INPUT;
                break;
            case OPT_TWO_INPUT:
                printf("请输入第二个操作数:");
                calNumTwo = scanInt();
                calculate(calType, calNumOne, calNumTwo);
                flowStatus = ROOT;
                break;
            case QUIT:
                return 0;
        }
    }
    return 0;
}

int scanInt() {
    int input;
    int rlt = scanf("%d", &input);
    if (rlt != 1) {
        printf("输入不合法，请重新输入\n");
        // 清空缓冲区数据
        while (getchar() != '\n');
        return scanInt();
    }
    return input;
}

void displayRootMenu() {
    for (int i = 0; i < ROOT_MENU_LEN; i++) {
        printf("%s", ROOT_MENU[i]);
    }
    printf("请输入：");
}

void calculate(enum CalculateType calType, int calNumOne, int calNumTwo) {
    switch (calType) {
        case ADD:
            printf("%d + %d = %d\n", calNumOne, calNumTwo, calNumOne + calNumTwo);
            break;
        case SUB:
            printf("%d - %d = %d\n", calNumOne, calNumTwo, calNumOne - calNumTwo);
            break;
        case MUL:
            printf("%d * %d = %d\n", calNumOne, calNumTwo, calNumOne * calNumTwo);
            break;
        case DIV:
            printf("%d / %d = %.2f\n", calNumOne, calNumTwo, (calNumOne * 1.0) / calNumTwo);
            break;
        default:
            break;
    }
}

enum CalculateType getCalType(int userInput) {
    switch (userInput) {
        case 1:
            return ADD;
        case 2:
            return SUB;
        case 3:
            return MUL;
        case 4:
            return DIV;
        default:
            return NONE;
    }
}
