/*
��ٳ��忡�� ���� �� �ȸ��� �޴��� ��Ʈ �޴��̴�. �ֹ��� ��, �ڽ��� ���ϴ� �ܹ��ſ� ���Ḧ �ϳ��� ���, ��Ʈ�� �����ϸ�, ������ �հ迡�� 50���� �� ������ ��Ʈ �޴��� ������ �ȴ�.

�ܹ��Ŵ� �� 3���� �������, �ߴ�����, �ϴ����Ű� �ְ�, ����� �ݶ�� ���̴� �� ������ �ִ�.

�ܹ��ſ� ������ ������ �־����� ��, ���� �� ��Ʈ �޴��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/

#include <iostream>
using namespace std;

int main(){
    int burger[3], drinks[2], sets[3][2], min_num;
    for(int i=0; i<3; i++)
        cin >> burger[i];
    for(int i=0; i<2; i++)
        cin >> drinks[i];

    for(int i=0; i<3; i++){
        for(int j=0; j<2; j++){
            sets[i][j] = burger[i] + drinks[j] - 50;
        }
    }

    min_num = sets[0][0];

    for(int i=0; i<6; i++){
        if(*(*sets+i)<min_num)
            min_num = *(*sets+i);
    }

    cout << min_num <<endl;

    return 0;
}
