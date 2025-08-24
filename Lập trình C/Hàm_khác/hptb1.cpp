#include <stdio.h>
#include <math.h>
void hptb1(float a1, float b1, float c1, float a2, float b2, float c2){
  float D= a1*b2-a2*b1;
  float Dx= c1*b2- c2*b1;
  float Dy= a1*c2-a2*c1;
  if(D==0){
      if(Dx==0&&Dy==0)
        printf("VSN");
      else
        printf("VN");
  }
  else{
      float x=Dx/D;
      float y=Dy/D;
      printf("%.5f %.5f", x, y);
  }
}
int main(){
	float a1, b1, c1, a2, b2, c2;
	scanf("%f %f %f", &a1, &b1, &c1);
	scanf("%f %f %f", &a1, &b1, &c1);
	hptb1(a1, b1, c1, a2, b2, c2);
}
