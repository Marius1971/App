package model;

public class Ceas {
	private int id;
	private String marca;
	private String model;
	private String gen;
	private String calibru;
	private String material;
	private String curea;
	private String mecanism;
	private String geam;
	private double pret;
	private int stoc;
	private String detalii;
	private String img;
	

	// Constructor fara id
	public Ceas(String marca, String model, String gen, String calibru, String material, String curea, String mecanism,
			String geam, double pret, int stoc, String detalii, String img) {
		super();
		this.marca = marca;
		this.model = model;
		this.gen = gen;
		this.calibru = calibru;
		this.material = material;
		this.curea = curea;
		this.mecanism = mecanism;
		this.geam = geam;
		this.pret = pret;
		this.stoc = stoc;
		this.detalii = detalii;
		this.img = img;
	}

	// Constructor cu id
	public Ceas(int id, String marca, String model, String gen, String calibru, String material, String curea,
			String mecanism, String geam, double pret, int stoc, String detalii, String img) {
		super();
		this.id = id;
		this.marca = marca;
		this.model = model;
		this.gen = gen;
		this.calibru = calibru;
		this.material = material;
		this.curea = curea;
		this.mecanism = mecanism;
		this.geam = geam;
		this.pret = pret;
		this.stoc = stoc;
		this.detalii = detalii;
		this.img= img;
	}

	public Ceas() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCalibru() {
		return calibru;
	}

	public void setCalibru(String calibru) {
		this.calibru = calibru;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getCurea() {
		return curea;
	}

	public void setCurea(String curea) {
		this.curea = curea;
	}

	public String getMecanism() {
		return mecanism;
	}

	public void setMecanism(String mecanism) {
		this.mecanism = mecanism;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public int getStoc() {
		return stoc;
	}

	public void setStoc(int stoc) {
		this.stoc = stoc;
	}

	public String getDetalii() {
		return detalii;
	}

	public void setDetalii(String detalii) {
		this.detalii = detalii;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public String getGeam() {
		return geam;
	}

	public void setGeam(String geam) {
		this.geam = geam;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Ceas [id=" + id + ", marca=" + marca + ", model=" + model + ", calibru=" + calibru + ", material="
				+ material + ", curea=" + curea + ", mecanism=" + mecanism + ", pret=" + pret + ", stoc=" + stoc
				+ ", detalii=" + detalii + "]";
	}

}
