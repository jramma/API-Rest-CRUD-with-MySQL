package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.Flor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlorDTO extends Flor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tipusFlor;

	static private List<String> paisos = new ArrayList<String>(Arrays.asList("austria", "belgium", "bulgaria",
			"croatia", "republic of Cyprus", "czech Republic", "denmark", "estonia", "finland", "france", "germany",
			"greece", "hungary", "ireland", "italy", "latvia", "lithuania", "luxembourg", "malta", "netherlands",
			"poland", "portugal", "romania", "slovakia", "slovenia", "spain", "sweden"));

	public FlorDTO() {

	}

	public FlorDTO(Integer id, String nom, String pais) {
		super(id, nom, pais);
		String respuesta;
		if (paisos.contains(getPais().toLowerCase())) {
			respuesta = "From EU";
		} else {
			respuesta = "Not from EU";
		}
		setTipusFlor(respuesta);
	}

	public String getTipusFlor() {
		return tipusFlor;
	}

	public void setTipusFlor(String tipusFlor) {
		this.tipusFlor = tipusFlor;
	}

}
