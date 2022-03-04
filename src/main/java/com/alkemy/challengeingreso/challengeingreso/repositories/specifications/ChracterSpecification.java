package com.alkemy.challengeingreso.challengeingreso.repositories.specifications;

import com.alkemy.challengeingreso.challengeingreso.dto.ChracterFiltersDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.ChracterEntity;
import com.alkemy.challengeingreso.challengeingreso.entities.FilmEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.Predicate;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.util.ArrayList;
import java.util.List;


@Component
public class ChracterSpecification {

    public Specification<ChracterEntity> getByFilters(ChracterFiltersDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filtersDTO.getName()!=null){
            if (StringUtils.hasLength(filtersDTO.getName().trim())){
                predicates.add(
                        criteriaBuilder.like(
                               criteriaBuilder.lower(root.get("name")),
                            "%" + filtersDTO.getName().trim().toLowerCase() + "%")
                );
            }}
            if (filtersDTO.getAge()!=null){
                predicates.add(
                        criteriaBuilder.equal(root.get("age"), filtersDTO.getAge()));
            }
            if (!CollectionUtils.isEmpty(filtersDTO.getFilmsId())){
                Join<FilmEntity, ChracterEntity> join = root.join("films", JoinType.INNER);
                Expression<String> filmsId = join.get("id");
                predicates.add(filmsId.in(filtersDTO.getFilmsId()));
            }
            /*
            if (!CollectionUtils.isEmpty(filtersDTO.getFilmId())){
                Join<FilmEntity, ChracterEntity> join = root.join("films", JoinType.INNER);
                Expression<String> filmsId = join.get("id");
                predicates.add(filmsId.in(filtersDTO.getFilmId()));
            }

             */

            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }
}
