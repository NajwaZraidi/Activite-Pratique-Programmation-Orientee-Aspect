package ma.enset.aop.aspects;

public aspect FirstAspect {

    pointcut pointCut1(): execution(* ma.enset.aop.test.Application.main(..));

//    before():pointCut1(){
//        System.out.println("--------------------------------");
//        System.out.println("Before main from AspectJ syntax");
//        System.out.println("--------------------------------");
//    }
//    after():pointCut1(){
//        System.out.println("--------------------------------");
//        System.out.println("After main from AspectJ syntax");
//        System.out.println("--------------------------------");
//    }
    void around () : pointCut1() {
        System.out.println("-------------------------------");
        System.out.println("Before main with aspectJ syntax");
        System.out.println("-------------------------------");
        //Execution de l'opération du mon pointcut
        proceed();
        System.out.println("-------------------------------");
        System.out.println("After main with aspectJ syntax");
        System.out.println("-------------------------------");
    }
}
