#include <iostream>
using namespace std;

int main(){
    int arr[10];
    int r_count = 10;

    for(int i = 0; i< 10; i++){
        cin >> arr[i];
        arr[i] = arr[i] % 42;
    }

    for(int i=0; i<10; i++){
        for(int j=i+1; j<10; j++){
            if(arr[i]==arr[j]){
                r_count--;
                break;
            }
        }
    }

    cout << r_count << endl;

    return 0;
}

