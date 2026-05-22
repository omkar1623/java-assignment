import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class Task4 {

    private DataSource dataSource;

    public List<ReportEntry> fetchMonthlyReport(String accountId,
                                                int month,
                                                int year) throws SQLException {

        List<ReportEntry> entries = new ArrayList<>();

        // FIX: Used try-with-resources to automatically close Connection and PreparedStatement
        try (
                Connection conn = dataSource.getConnection();

                PreparedStatement ps = conn.prepareStatement(
                        "SELECT * FROM report_entries " +
                        "WHERE account_id = ? AND MONTH(entry_date) = ? " +
                        "AND YEAR(entry_date) = ?"
                )
        ) {

            ps.setString(1, accountId);
            ps.setInt(2, month);
            ps.setInt(3, year);

            // FIX: ResultSet also managed with try-with-resources
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    entries.add(mapRow(rs));
                }
            }
        }

        return entries;
    }

    private ReportEntry mapRow(ResultSet rs) {

        return new ReportEntry();
    }

    public static void main(String[] args) {

        System.out.println("Task4 compiled successfully");
    }
}

class ReportEntry {

}