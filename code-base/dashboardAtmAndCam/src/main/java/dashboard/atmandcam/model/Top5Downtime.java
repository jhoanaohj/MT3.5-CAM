//package dashboard.atmandcam.model;
//
//import javax.persistence.ColumnResult;
//import javax.persistence.ConstructorResult;
//import javax.persistence.Entity;
//import javax.persistence.NamedNativeQueries;
//import javax.persistence.NamedNativeQuery;
//import javax.persistence.SqlResultSetMapping;
//
//@SqlResultSetMapping(name = "top5Result", classes = {
//		@ConstructorResult(targetClass = dashboard.atmandcam.model.Top5Downtime.class, columns= {
//				@ColumnResult(name = "event_description", type = String.class)
//		})
//})
//
//@NamedNativeQueries({
//	@NamedNativeQuery(
//			name = "GetTop5Downtime.getData",
//			query = "",
//			resultSetMapping = "top5Result"
//			)
//})
//
//
//@Entity
//public class Top5Downtime {
//
//}
