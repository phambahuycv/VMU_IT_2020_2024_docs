#include <stdio.h>

typedef struct
{
    int n;
}Data;

typedef struct TagNode
{
    Data infor;
    struct TagNode *link;
}Node;

typedef struct
{
    Node *pHead,*pTail;
    int spt;
}Queue;

//Tao danh sach rong
void initQ(Queue *Q)
{
    Q->pHead = NULL;
    Q->pTail = NULL;
    Q->spt = 0;
}

//Kiem tra rong
int emptyQ(Queue Q)
{
    return (Q.spt==0);
}

//Them phan tu o cuoi
void addQ(Queue *Q, Data x)
{
    Node *pp;
    pp = (Node*) malloc(sizeof(Node));
    pp->infor = x;
    pp->link =NULL;
    if(emptyQ(*Q))
    {
        Q->pHead = pp;
        Q->pTail = pp;
    }
    else
    {
        Q->pTail->link = pp;
        Q->pTail = pp;
    }
    Q->spt++;
}

//Xoa phan tu o dau
void delQ(Queue *Q)
{
    Node *pp;
    if(emptyQ(*Q))    return;
    else
    {
        pp = Q->pHead;
        Q->pHead = pp->link;
        free(*pp);
        Q->spt--;
        if(Q->pHead == NULL)    Q->pTail = NULL;
    }
}

//Lay gia tri phan tu dau
Data getQ(Queue Q)
{
    return Q.pHead->infor;
}
