package com.alkemy.challengeingreso.challengeingreso.repositories.specifications;

import com.alkemy.challengeingreso.challengeingreso.dto.FilmFiltersDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.FilmEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;

@Component
public class FilmSpecification {

    public Specification<FilmEntity> getByFilters(FilmFiltersDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(filtersDTO.getTitle()!=null) {
                if (StringUtils.hasLength(filtersDTO.getTitle())) {
                    predicates.add(
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("title")),
                                    "%" + filtersDTO.getTitle().toLowerCase() + "%"
                            )
                    );
                }
            }
            String orderByField = "title";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc((root.get(orderByField)))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
