#include<iostream>
#include<vector>
using namespace std;
int modInverse(int a, int m){ 
    a=a%m; 
    for(int x=-m;x<m;x++) 
       if((a*x)%m==1) 
          return x; 
} 
void getCofactor(vector<vector<int> > &a, vector<vector<int> > &temp, int p, int q, int n){ 
    int i=0,j=0; 
    for(int row=0;row<n;row++){ 
        for(int col=0;col<n;col++){ 
            if(row!=p&&col!=q){ 
                temp[i][j++] = a[row][col]; 
                if (j==n-1){ 
                    j=0; 
                    i++; 
                } 
            } 
        } 
    } 
}
int determinant(vector<vector<int> > &a, int n, int N){ 
    int D = 0;
    if(n==1) 
        return a[0][0]; 
    vector<vector<int> > temp(N, vector<int>(N));
    int sign = 1;
    for(int f=0;f<n;f++){ 
        getCofactor(a, temp, 0, f, n); 
        D += sign * a[0][f] * determinant(temp, n - 1, N); 
        sign = -sign; 
    }
    return D; 
} 
void adjoint(vector<vector<int> > &a,vector<vector<int> > &adj,int N){ 
    if(N == 1){ 
        adj[0][0] = 1; 
        return; 
    } 
    int sign = 1;
    vector<vector<int> > temp(N, vector<int>(N));
    for(int i=0;i<N;i++){ 
        for(int j=0;j<N;j++){ 
            getCofactor(a, temp, i, j, N); 
            sign = ((i+j)%2==0)? 1: -1; 
            adj[j][i] = (sign)*(determinant(temp, N-1 , N)); 
        } 
    } 
} 
bool inverse(vector<vector<int> > &a, vector<vector<int> > &inv, int N){ 
    int det = determinant(a, N, N); 
    if(det == 0){ 
        return false; 
    }	
	int invDet = modInverse(det,256);
    vector<vector<int> > adj(N, vector<int>(N));
    adjoint(a, adj, N);  
    for(int i=0;i<N;i++) 
        for(int j=0;j<N;j++) 
            inv[i][j] = (adj[i][j]*invDet)%256; 
    return true; 
} 
int main(){	
	int x,y,i,j,k,n=2;  
    cout<<"Nhap ma tran co kich thuoc 2x2\n";
    int b[n][n];
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            cin>>b[i][j];
        }
    }
    cout<<"Nhap ban ro\n";
    string banRo;
    cin>>banRo;
    int tp = (n-banRo.size()%n)%n;
    for(i=0;i<tp;i++){
        banRo+='x';
    }
    k=0;
    string banMa="";
    while(k<banRo.size()){
        for(i=0;i<n;i++){
            int sums = 0;
            int temps = k;
            for(j=0;j<n;j++){
                sums += (b[i][j]%256*(banRo[temps++]-'a')%256)%256;
                sums = sums%256;
            }
            banMa+=(sums+'a');
        }
        k+=n;
    }
    cout<<"Ban ma: "<<banMa<<'\n';   
    cout<<"Nhap khoa giai ma\n";
    vector<vector<int> > a(n, vector<int>(n));
    vector<vector<int> > adj(n, vector<int>(n));
    vector<vector<int> > inv(n, vector<int>(n));
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            cin>>a[i][j];
        }
    }
    if(inverse(a,inv,n)){
    }
    k=0;
    string Kq;
    while(k<banMa.size()){
        for(i=0;i<n;i++){
            int sum = 0;
            int temp = k;
            for(j=0;j<n;j++){
                sum += ((inv[i][j] + 256)%256*(banMa[temp++]-'a')%256)%256;
                sum = sum%256;
            }
            Kq+=(sum+'a');
        }
        k+=n;
    }
    cout<<"Giai ma, ban ro: "<<Kq;
    return 0;    
}
