package www.starcom.com.jualanpraktis.model_retrofit.rekening_jp;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("rekening")
	private String rekening;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("pemilik_rekening")
	private String pemilikRekening;

	@SerializedName("id_bank")
	private String idBank;

	@SerializedName("nama_bank")
	private String namaBank;

	public void setRekening(String rekening){
		this.rekening = rekening;
	}

	public String getRekening(){
		return rekening;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setPemilikRekening(String pemilikRekening){
		this.pemilikRekening = pemilikRekening;
	}

	public String getPemilikRekening(){
		return pemilikRekening;
	}

	public void setIdBank(String idBank){
		this.idBank = idBank;
	}

	public String getIdBank(){
		return idBank;
	}

	public void setNamaBank(String namaBank){
		this.namaBank = namaBank;
	}

	public String getNamaBank(){
		return namaBank;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"rekening = '" + rekening + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",pemilik_rekening = '" + pemilikRekening + '\'' + 
			",id_bank = '" + idBank + '\'' + 
			",nama_bank = '" + namaBank + '\'' + 
			"}";
		}
}