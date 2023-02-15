package com.javamentor.qa.platform.dao.util;

import org.springframework.stereotype.Component;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Component
public class SingleResultUtil {
    public static <T> Optional<T> getSingleResultOrNull(TypedQuery<T> var) {
        try {
            return Optional.of(var.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static <T> Optional<T> getSingleResultOrNull(Query var) {
        try {
            return Optional.of((T) var.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
