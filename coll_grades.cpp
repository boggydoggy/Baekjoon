#include <iostream>
using namespace std;

int main(){
    int test_case;
    int num;


    float percent;
    cin >> test_case;

    for(int i=0; i<test_case; i++){
        cin >> num;
        int student[num];
        float cnt=0.0;
        float avr=0.0;

        for(int j=0; j<num; j++){
            cin >> student[j];
            avr += student[j];
        }
        avr /= num;

        for(int j=0; j<num; j++){
            if(student[j]>avr){
                cnt++;
            }
        }
        percent = cnt / num * 100;

        cout << fixed;
        cout.precision(3);
        cout << percent << "%" << endl;
    }
}
