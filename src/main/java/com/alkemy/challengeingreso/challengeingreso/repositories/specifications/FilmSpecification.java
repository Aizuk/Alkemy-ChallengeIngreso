package com.alkemy.challengeingreso.challengeingreso.repositories.specifications;

import com.alkemy.challengeingreso.challengeingreso.dto.FilmFiltersDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.ChracterEntity;
import com.alkemy.challengeingreso.challengeingreso.entities.FilmEntity;
import com.alkemy.challengeingreso.challengeingreso.entities.GenreEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
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
            if(filtersDTO.getGenreId()!=null){
                Join<GenreEntity, FilmEntity> join = root.join("genre", JoinType.INNER);
                Expression<String> genreId = join.get("id");
                predicates.add(criteriaBuilder.equal(genreId, filtersDTO.getGenreId()));
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
