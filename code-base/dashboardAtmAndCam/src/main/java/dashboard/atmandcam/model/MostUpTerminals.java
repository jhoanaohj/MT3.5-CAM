package dashboard.atmandcam.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "mostUpTerminals", classes = {
		@ConstructorResult(targetClass = dashboard.atmandcam.model.MostUpTerminals.class, columns= {
				@ColumnResult(name = "terminal_id", type = String.class),
				@ColumnResult(name = "machine_name", type = String.class),
				@ColumnResult(name = "most_up_terminals", type = String.class)
		})
})

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "GetDefaultMostUpTerminal.getData",
			query = "SELECT da.terminal_id, di.machine_name, ROUND(AVG(da.availability_percentage),2) AS most_up_terminals\r\n" + 
					"FROM dashboard.availability da\r\n" + 
					"INNER JOIN dashboard.inventory di ON da.terminal_id = di.terminal_id\r\n" + 
					"WHERE da.availability_date = ?1\r\n" + 
					"AND di.machine_type = 'CAM'\r\n" + 
					"GROUP BY da.terminal_id, di.machine_name\r\n" + 
					"ORDER BY most_up_terminals DESC LIMIT 5",
			resultSetMapping =  "mostUpTerminals"
			),
	@NamedNativeQuery(
			name = "GetRangedMostUpTerminal.getData",
			query = "SELECT da.terminal_id, di.machine_name, ROUND(AVG(da.availability_percentage),2) AS most_up_terminals\r\n" + 
					"FROM dashboard.availability da\r\n" + 
					"INNER JOIN dashboard.inventory di ON da.terminal_id = di.terminal_id\r\n" + 
					"WHERE da.availability_date BETWEEN ?1 AND ?2 \r\n" + 
					"AND di.machine_type = 'CAM'\r\n" + 
					"GROUP BY da.terminal_id, di.machine_name\r\n" + 
					"ORDER BY most_up_terminals DESC LIMIT 5",
			resultSetMapping = "mostUpTerminals"
			)
})

@Entity
public class MostUpTerminals {

	@Id
	private Long id;
	
	@JsonProperty("terminal_id")
	private String terminalId;
	
	@JsonProperty("machine_name")
	private String machineName;
	
	@JsonProperty("most_up_terminal")
	private String mostUpTerminal;
	
	public MostUpTerminals(String termId, String machName, String mostUpTerm) {
		super();
		this.terminalId = termId;
		this.machineName = machName;
		this.mostUpTerminal = mostUpTerm;
	}
	
	public MostUpTerminals() {}
	
	
}
