package com.sfallmann.jpah2ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.modelmapper.ModelMapper;

/**
 * Utils
 */
public class Utils {

  public final static ModelMapper modelMapper = new ModelMapper();
  public final static Predicate filterBuilder(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder,
      Map<String, String> criterias) {
    List<Predicate> predicates = new ArrayList<>();

    for (String key : criterias.keySet()) {

      From<?, ?> q = root;
      String value = criterias.get(key).toLowerCase();
      String[] paths = key.split("\\.");
      int length = paths.length;

      for (int i = 0; i < length; i++) {
        if (i == 0) {
          q = root;
        }

        if (i == length - 1) {
          key = paths[i];
        } else {
          q = q.join(paths[i]);
        }
      }

      if (value != null) {
        try {
          predicates.add(criteriaBuilder
              .and(criteriaBuilder.like(criteriaBuilder.lower(q.get(key).as(String.class)), "%" + value + "%")));
        } catch (Exception e) {
          System.out.println(e);

        }
      }
    }
    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

  }
}