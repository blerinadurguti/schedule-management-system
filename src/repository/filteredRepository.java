package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.filtered;

public class filteredRepository {

    private DBConnection connection;

    public filteredRepository(){
        this.connection = DBConnection.getConnection();
    }

    public ObservableList<filtered> getData() throws SQLException{

        String query = "Select * from filtered";
        ResultSet res = this.connection.executeQuery(query);
        ObservableList<filtered> f = FXCollections.observableArrayList();

        while(res.next()) {
            f.add(filtered.fromResultSet(res));
        }

        return f;
    }


}
