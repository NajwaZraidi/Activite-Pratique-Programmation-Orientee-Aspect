package ma.enset.service;


import ma.enset.aspects.Log;
import ma.enset.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class IMetierImpl implements IMetier {


    @Override
    @Log
    @SecuredByAspect(roles={"ADMIN","USER"})
    public void process() {
        System.out.println("Business Process . . . .");
    }

    @Override
    @Log
    @SecuredByAspect(roles={"ADMIN"})
    public double compute() {
        double data=18;
        System.out.println("Business computing and returning");
        return data;
    }
}
