package com.alkemy.challengeingreso.challengeingreso.repositories.specifications;

import com.alkemy.challengeingreso.challengeingreso.dto.ChracterFiltesrDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.ChracterEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

@Component
public class ChracterSpecification {

    public Specification<ChracterEntity> getByFilters(ChracterFiltesrDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasLength(filtersDTO.getName())){
                predicates.add(
                        criteriaBuilder.like(
                               criteriaBuilder.lower(root.get("name")),
                            "%" + filtersDTO.getName().toLowerCase() + "%")
                        )
                );
            }
        };
    }
}
