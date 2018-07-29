import java.util.Random;

// class for data encryption
class Data
{	String	data;		
	
	// set data method
	void setData (int data)
	{
		if (data >999 && data < 10000)
			this.data = Integer.toString(data);
	}
	
	// return data method
	String getData ()
	{
		return data;
	}

	// encryption method 
	void encrypt ()
	{	
		int x, x0, x00, x000, rawData;
		rawData = Integer.parseInt(data);
		x = rawData % 10;
		x += 7;
		x %= 10;
		
		x0 = (rawData % 100) / 10;
		x0 += 7;
		x0 %= 10;
		
		x00 = (rawData % 1000) / 100;
		x00 += 7;
		x00 %= 10;
		
		x000 = rawData / 1000;
		x000 += 7;
		x000 %= 10;
		
		int temp;
		temp = x0;
		x0 = x000;
		x000 = temp;
		
		temp = x00;
		x00 = x;
		x = temp;
		
		data = ""; 
		data = data.concat(Integer.toString(x000));
		data = data.concat(Integer.toString(x00));
		data = data.concat(Integer.toString(x0));
		data = data.concat(Integer.toString(x));
	}
	// decryption method
	void Decrypt ()
	{
		int x, x0, x00, x000, rawData;
		rawData = Integer.parseInt(data);
		x = rawData % 10;
		x -= 7;
		if (x < 0) x += 10;
		
		x0 = (rawData % 100) / 10;
		x0 -= 7;
		if (x0 < 0) x0 += 10;
		
		x00 = (rawData % 1000) / 100;
		x00 -= 7;
		if (x00 < 0) x00 += 10;
		
		x000 = rawData / 1000;
		x000 -= 7;
		if (x000 < 0) x000 += 10;
		
		int temp;
		temp = x0;
		x0 = x000;
		x000 = temp;
		
		temp = x00;
		x00 = x;
		x = temp;
		
		
		data = ""; 
		data = data.concat(Integer.toString(x000));
		data = data.concat(Integer.toString(x00));
		data = data.concat(Integer.toString(x0));
		data = data.concat(Integer.toString(x));
	}
}


public class Cryptography 
{

	public static void main(String[] args) 
	{	
		// Generate Data object for manipulation
		Data data = new Data();
		
		// Generate random no for method verification
		Random test = new Random();
		
		for (int i = 1 ; i < 20 ; i++)
		{
			int no = test.nextInt(9) + test.nextInt(9) * 10 + test.nextInt(9) * 100 + test.nextInt(9) * 1000;
			data.setData(no);
			System.out.println(data.getData());
			data.encrypt();
			System.out.println(data.getData());
			data.Decrypt();
			System.out.println(data.getData());
			
			System.out.printf("%nNew set.%n");
		}
		

	}

}
