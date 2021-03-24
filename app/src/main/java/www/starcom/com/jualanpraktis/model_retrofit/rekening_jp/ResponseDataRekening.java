package www.starcom.com.jualanpraktis.model_retrofit.rekening_jp;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDataRekening{

	@SerializedName("data")
	private List<DataItem> data;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDataRekening{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}