package dashboard.atmandcam.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@SqlResultSetMapping(name = "mostDownTerminals", classes = {
		@ConstructorResult(targetClass = dashboard.atmandcam.model.MostDownTerminals.class, columns= {
				@ColumnResult(name = "terminal_id", type = String.class),
				@ColumnResult(name = "machine_name", type = String.class),
				@ColumnResult(name = "most_down_terminals", type = String.class)
		})
})

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "GetDefaultMostDownTerminal.getData",
			query = "SELECT da.terminal_id, di.machine_name, ROUND(AVG(da.availability_percentage),2) AS most_down_terminals\r\n" + 
					"FROM dashboard.availability da\r\n" + 
					"INNER JOIN dashboard.inventory di ON da.terminal_id = di.terminal_id\r\n" + 
					"WHERE da.availability_date = ?1\r\n" + 
					"AND di.machine_type = 'CAM'\r\n" + 
					"GROUP BY da.terminal_id, di.machine_name\r\n" + 
					"ORDER BY most_down_terminals ASC LIMIT 5",
			resultSetMapping =  "mostDownTerminals"
			),
	@NamedNativeQuery(
			name = "GetRangedMostDownTerminal.getData",
			query = "SELECT da.terminal_id, di.machine_name, ROUND(AVG(da.availability_percentage),2) AS most_down_terminals\r\n" + 
					"FROM dashboard.availability da\r\n" + 
					"INNER JOIN dashboard.inventory di ON da.terminal_id = di.terminal_id\r\n" + 
					"WHERE da.availability_date BETWEEN ?1 AND ?2 \r\n" + 
					"AND di.machine_type = 'CAM'\r\n" + 
					"GROUP BY da.terminal_id, di.machine_name\r\n" + 
					"ORDER BY most_down_terminals ASC LIMIT 5",
			resultSetMapping = "mostDownTerminals"
			)
})

@Entity
public class MostDownTerminals {
	
	@Id
	private Long id;
	
	@JsonProperty("terminal_id")
	private String terminalId;
	
	@JsonProperty("machine_name")
	private String machineName;
	
	@JsonProperty("most_down_terminal")
	private String mostDownTerminal;
	
	public MostDownTerminals(String termId, String machName, String mostDownTerm) {
		super();
		this.terminalId = termId;
		this.machineName = machName;
		this.mostDownTerminal = mostDownTerm;
	}
	
	public MostDownTerminals() { }
	
}

