#include<bits/stdc++.h>
using namespace std;
int main(){
	int n;
	cin>>n;
	int input[n];
	for(int i=0;i<n;i++)
	cin>>input[i];
	
	int hit=0,fault=0;
	int c=0;
	int frame[3]={0};
	for(int i=0;i<n;i++)
	{
		bool check=false;
		for(int j=0;j<3;j++){
			if(frame[j]==input[i])
			{
				hit++;
				check=true;
			}
		}
		if(check==false){
			frame[c%3]=input[i];
			c++;
			fault++;
		}
	}
	cout<<hit<<endl;
	cout<<fault<<endl;
	return 0;
}
