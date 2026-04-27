package database

class DatabaseConnectionProvider {

    static ConnectionProvider getProvider(String databaseType) {
        switch (databaseType) {
            case "postgres":
                return new PostgresConnectionProvider()
            default:
                throw new IllegalArgumentException("Banco não suportado")
        }
    }
}