package com.titanesexample.exampletitanes.interfaceService;

import com.titanesexample.exampletitanes.modelo.Empresa;

import java.util.List;
import java.util.Optional;

public interface IempresaService {
    public List<Empresa>listar();
    public Optional<Empresa>listarId(int id);
    public int save(Empresa p);
    public void delete(int id);
}
