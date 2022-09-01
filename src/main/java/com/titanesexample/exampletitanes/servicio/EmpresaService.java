package com.titanesexample.exampletitanes.servicio;

import com.titanesexample.exampletitanes.interfaceService.IempresaService;
import com.titanesexample.exampletitanes.interfaces.IEmpresa;
import com.titanesexample.exampletitanes.modelo.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements IempresaService {
    @Autowired
    private IEmpresa data;

    @Override
    public List<Empresa> listar() {

        return (List<Empresa>)data.findAll();
    }

    @Override
    public Optional<Empresa> listarId(int id) {

        return data.findById(id);
    }

    @Override
    public int save(Empresa e) {
        int res=0;
        Empresa empresa=data.save(e);
        if (!empresa.equals(null)) {
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
