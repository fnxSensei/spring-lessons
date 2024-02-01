import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

/*
@Component
public class TestJdbcTemplate {

    private JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public TestJdbcTemplate(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void examples(){
        Тип result = jdbcTemplate.queryForObject("", Тип.class);
        jdbcTemplate.update("INSERT INTO ИМЯ_ТАБЛИЦЫ VALUES (?, ?, ?, ?)", значения параметров);

        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("имя_параметра", значение);
        Тип result namedParameterJdbcTemplate.queryForObject("SELECT столбцы FROM ИМЯ_ТАБЛИЦЫ WHERE столбец = :имя_параметра", namedParameters, Тип.class);
    }
}
*/