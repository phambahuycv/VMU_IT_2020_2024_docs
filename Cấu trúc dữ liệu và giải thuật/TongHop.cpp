#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int key;
}Data;

typedef struct TagNode {
    Data infor;
    struct TagNode *link;
}Node;

typedef struct {
    Node *pHead,*pTail;
    int spt;
}LList;

int emptyList(LList L) {
    return (L.spt==0);
}

void initList(LList *L) {
    L->pHead = NULL;
    L->pTail = NULL;
    L->spt = 0;
}

void insert_Tail(LList *L, Data x) {
    Node *pp;
    pp = (Node*) malloc(sizeof(Node));
    pp->infor = x;
    pp->link =NULL;
    if(emptyList(*L))
    {
        L->pHead = pp;
        L->pTail = pp;
    }
    else
    {
        L->pTail->link = pp;
        L->pTail = pp;
    }
    L->spt++;
}

void insert_After(LList *L, Node *q, Data x) {
    Node *pp;
    if(NULL == q)   return;
    else
    {
        pp = (Node*) malloc(sizeof(Node));
        pp->infor = x;
        pp->link = q->link;
        q->link = pp;
        if(q == L->pTail)   L->pTail = pp;
    }
}

void del_After(LList *L, Node *q) {
    Node *pp;
    if(NULL == q)   return;
    else
    {
        pp = q->link;
        q->link = pp->link;
        free(pp);
        L->spt--;
        if(NULL == q->link) L->pTail = q;
    }
}

void nhap_ds(LList *L) {
    Data x;
    initList(L);
    do{
        scanf("%d", &x.key);
        if(x.key != -1)	 insert_Tail(L,x);
    }
    while(x.key != -1);
}

void in_ds(LList L) {
    Node *pp = L.pHead;
    while(NULL != pp)
    {
        printf("%d ", pp->infor);
        pp = pp->link;
    }
}

void bo_sung_vao_vi_tri(LList *L) {
    int vt;
    Data x;
    printf("\nNhap so nguyen: ");
    scanf("%d", &x.key);
    printf("\nBo sung vao vi tri K (K <= %d): ", L->spt);
    scanf("%d", vt);
    Node *pp = L->pHead;
    int i = 1;
    while(i < vt-1) {
        pp = pp->link;
        i++;
    }
    insert_After(L, pp, x);
}

void xoa_vi_tri(LList *L) {
    int vt;
    printf("Xoa phan tu o vi tri K (K <= %d): ", L->spt);
    scanf("%d", &vt);
    Node *pp = L->pHead;
    int i = 1;
    while(i < vt-1) {
        pp = pp->link;
        i++;
    }
    del_After(L, pp);
}

void xoa_phan_tu_am(LList *L) {
    Node *pp = L->pHead;
    while(pp->infor.key < 0) {
        L->pHead = pp->link;
        free(pp);
        L->spt--;
        if(L->pHead == NULL)    L->pTail = NULL;
    }
    while(pp->link != NULL) {
        if(pp->link->infor.key <0)   del_After(L, pp);
        pp = pp->link;
    }
}

int main() {
    int x;
    LList L;
    printf("Nhap danh sach cac so nguyen (nhap -1 de ket thuc):\n");
    nhap_ds(&L);
    printf("\n==============================================================\n");
    printf("Danh sach vua nhap la:\n");
    in_ds(L);
    printf("\n==============================================================\n");
    bo_sung_vao_vi_tri(&L);
    printf("Danh sach sau khi bo sung la:\n");
    in_ds(L);
    printf("\n==============================================================\n");
    xoa_vi_tri(&L);
    printf("Danh sach sau khi xoa phan tu do la:\n");
    in_ds(L);
    printf("\n==============================================================\n");
    xoa_phan_tu_am(&L);
    printf("Danh sach sau khi xoa cac phan tu am la:\n");
    in_ds(L);
    printf("\n==============================================================\n");
    return 0;
}
