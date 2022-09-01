package com.titanesexample.exampletitanes.interfaces;

import com.titanesexample.exampletitanes.modelo.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresa extends CrudRepository<Empresa, Integer> {
}
