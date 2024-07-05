#include <iostream>
using namespace std;

int main() {
    // 여기에 코드를 작성해주세요.
    int a = 3;
    int b = 5;
    a ^= b;
    b ^= a;
    a ^= b;
    cout << a << endl;
    cout << b << endl; 
    return 0;
}