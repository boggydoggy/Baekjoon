/*
�����̴� �⸻��縦 ���ƴ�. �����̴� ������ �����ؼ� ���� ��������� �ߴ�. �ϴ� �����̴� �ڱ� ���� �߿� �ִ��� �����. �� ���� M�̶�� �Ѵ�. �׸��� ���� ��� ������ ����/M*100���� ���ƴ�.

���� ���, �������� �ְ����� 70�̰�, ���������� 50�̾����� ���������� 50/70*100�� �Ǿ� 71.43���� �ȴ�.

�������� ������ ���� ������ ���� ������� ��, ���ο� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

*/

#include <iostream>
using namespace std;

int main(){
    int num;
    float maximum;
    float average = 0.0;
    cin >> num;

    float arr[num];
    for(int i=0; i<num; i++){
        cin >> arr[i];
    }

    maximum = arr[0];
    for(int i=0; i<num; i++){
        if(arr[i]>maximum)
            maximum = arr[i];
    }

    for(int i=0; i<num; i++){
        arr[i] = arr[i] / maximum * 100;
        average += arr[i];
    }
    average /= num;

    cout << average << endl;
}
