import java.util.*;
public class SLS{
	public static void main(String args[])
	{	double[][] e=new double[100][100];
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				e[i][j]=0;
			}
		}
	int[] x=new int[100];
	int[] y=new int[100];
	double[] m=new double[101];
	m[0]=0;
	int c;
	System.out.println("Enter the cost value:");
	Scanner scan=new Scanner(System.in);
	c=scan.nextInt();
	Random randomGenerator = new Random();
	for (int i = 0; i < 100; ++i){
		x[i] = 100-randomGenerator.nextInt(200);
		y[i] = 100-randomGenerator.nextInt(200);
	}
	int temp;
	for(int i = 0; i < 100; i++){
		for(int j = 1; j < (100-i); j++){
			if(x[j-1] > x[j]){
				temp = x[j];
				
				x[j]=x[j-1];
				x[j-1]=temp;
				temp=	y[j];
				y[j]=y[j-1];
				y[j-1]=temp;
			}
		}
	}
	double a,b;
	for(int i=0;i<100;i++)
	{	
		for(int j=0;j<i;j++)
		{	int s1=0,s2=0,s3=0,s4=0;
			for(int k=j;k<i;k++)
			{	s1+=x[k]*y[k];
				s2+=x[k];
				s3+=y[k];
				s4+=x[k]*x[k];	
			}
			
			try{
				a=((i-j+1)*s1-(s2*s3))/((i-j+1)*s4-(s2*s2));
				b=(s3-a*s2)/(i-j+1);
				for(int k=j;k<=i;k++)
					e[j][i]+=(y[k]-a*x[k]-b)*(y[k]-a*x[k]-b);
				
			}catch(Exception ex){
				System.out.println("Invalid value of a found ramdomly!Programm Exiting!!!");
				System.exit(0);
			}
		}
		
	}
	int segm=0;
	for(int i=0;i<100;i++)
	{	double min=e[0][i]+c;
		
		for(int j=0;j<=i;j++)
		{	if(min>(e[j][i]+c+m[j-1+1]))
			{	min=(e[j][i]+c+m[j-1+1]);
				
			}
		
		}
		m[i+1]=min;
		if(m[i+1]>=m[i]+c)
			segm++;
	}
	System.out.println("The segments are:"+segm);
	System.out.println("Final Cost is:"+m[100]);
	System.out.println("Required segments are:");
	for(int i=0;i<100;i++)
	{	if(m[i+1]>=m[i]+c)
		System.out.print("("+x[i]+","+y[i]+")->");
		
	}
	System.out.print("("+x[99]+","+y[99]+")");
	}
}