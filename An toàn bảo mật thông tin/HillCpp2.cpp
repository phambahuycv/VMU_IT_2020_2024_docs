#include<iostream>
#include<string>
using namespace std;
const int n = 26;


inline int mod_euclidean(int num, int mod_num)
{
    int m = num % mod_num;
    if(m < 0) m = (mod_num < 0) ? m - mod_num : m + mod_num;
    return m;
}

int gcd(int first_num, int second_num)
{
    while (first_num * second_num > 0)
    {
        if (first_num > second_num) first_num = mod_euclidean(first_num, second_num);
        else second_num = mod_euclidean(second_num, first_num);
    }
    return first_num + second_num;
}
//inline void getkeymatrix(string key, int keymatrix[][10], int size)
//{
//    int k = 0;
//    for(int row = 0; row < size; row++)
//        for(int col = 0; col < size; col++)
//            keymatrix[row][col] = key[k++] % 'a';
//}

int modinverse(int a, int n)
{
    int i = n, v = 0, d = 1;
    while (a>0) {
        int t = i/a, x = a;
        a = i % x;
        i = x;
        x = d;
        d = v - t*x;
        v = x;
    }
    v %= n;
    if (v<0) v = (v+n)%n;
    return v;
}

inline void getkeymatrixint(int keymatrix[][5], int size)
{
    for(int row = 0; row < size; row++)
        for(int col = 0; col < size; col++)
            cin >> keymatrix[row][col];
}

inline void gettextmatrix(string ciphertext, int textmatrix[][10], int rows)
{
    int k = 0, uporlow;
    for(int row = 0; row < rows; row++)
        for(int col = 0; col < 2; col++)
        {
            uporlow = ciphertext[k] >= 'a' ? 'a' : 'a';
            textmatrix[row][col] = ciphertext[k++] % uporlow;
        }
}

inline void getdecryptkey(int keymatrix[][5], int size)
{
    swap(keymatrix[0][0], keymatrix[1][1]);
    keymatrix[1][0] *= -1;
    keymatrix[0][1] *= -1;
    int detinvert = modinverse(keymatrix[0][0]*keymatrix[1][1] - keymatrix[1][0]*keymatrix[0][1], n);
    for(int row = 0; row < size; row++)
        for(int col = 0; col < size; col++)
            keymatrix[row][col] = (detinvert * keymatrix[row][col]) % 26;
}

inline string hill_decode(string ciphertext, int keymatrix[][5], int mod_number)
{
    int uporlow = 0;

//    int keymatrix[10][10] {};
//    getkeymatrix(key, keymatrix, 2);

    int numofrows = ciphertext.length() / 2;
    int textmatrix[2][10] ;
    gettextmatrix(ciphertext, textmatrix ,numofrows);

    int ciphermatrix[2][2] ;

    int row, col, tmp, k = 0;
    for(row = 0; row < numofrows; row++)
        for(col = 0; col < 2; col++)
        {
            uporlow = ciphertext[k++] >= 'a' ? 'a' : 'a';
            for(tmp = 0; tmp < 2; tmp++)
                ciphermatrix[row][col] += textmatrix[row][tmp] * keymatrix[tmp][col];
            ciphermatrix[row][col] %= 26;
            ciphermatrix[row][col] = mod_euclidean(ciphermatrix[row][col], mod_number) + uporlow;
        }
    //string ciphertext = "";
    for(row = 0; row < numofrows; row++)
        for(col = 0; col < 2; col++)
            ciphertext += ciphermatrix[row][col];
    return ciphertext;
}

int main()
{

    string ciphertext;
    int key[5][5] ;
    cout << "input plain text:\n";
    cin >> ciphertext;

    cout << "input key matrix:\n";
    getkeymatrixint(key, 2);
    while(gcd(key[0][0]*key[1][1] - key[1][0]*key[0][1], n) != 1)
    {
        cout << "key is not valid, input again";
        getkeymatrixint(key, 2);
    }
    getdecryptkey(key,2);
    ciphertext = hill_decode(ciphertext, key, n);
    cout << "cipher text: " << ciphertext;

}
