package com.gogabot.graphql.graphql;

import com.gogabot.graphql.db.UserDB;
import com.gogabot.graphql.model.User;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDataFetcher {
    UserDB userDB = new UserDB();

    public DataFetcher<List<User>> getAllUsers() {
        return dataFetchingEnvironment -> userDB
                .getAllUsers();
    }

    public DataFetcher getUserById() {
        return dataFetchingEnvironment -> userDB
                .getUserById(dataFetchingEnvironment.getArgument("id"))
                .orElse(new User(0, "None", "None", 0));
    }

    public DataFetcher<List<User>> getUsersYoungerThan() {
        return dataFetchingEnvironment -> userDB
                .getUsersYoungerThan(dataFetchingEnvironment.getArgument("age"));

    }

    public DataFetcher<User> deleteUser() {
        return dataFetchingEnvironment -> userDB
                .deleteUser(dataFetchingEnvironment.getArgument("id"));

    }
}
