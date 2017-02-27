package spoon.test.template.testclasses.transfo;

import spoon.processing.AbstractProcessor;
import spoon.template.Substitution;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtType;
import spoon.template.ExtensionTemplate;
import spoon.reflect.declaration.CtParameter;
import spoon.support.reflect.declaration.CtParameterImpl;
import spoon.reflect.reference.CtTypeReference;

import spoon.template.Parameter;
import spoon.template.Local;

import java.util.*;

public class MyTrans extends AbstractProcessor<CtClass> {
  public void process (CtClass ctClass) {
    CtParameter newPara = getFactory().createParameter();
    newPara.setSimpleName("abc");
    newPara.setType(getFactory().Type().floatPrimitiveType());

    ParaTemp temp = new ParaTemp();

    if (ctClass.getSimpleName().equals("Hello")) {
      for (Object mo : ctClass.getAllMethods()) {
        CtMethod m = (CtMethod)mo;
        if (m.getSimpleName().equals("print")) {
          temp.type = m.getType();
          temp.mName = m.getSimpleName();
          temp.body = m.getBody();
          temp.thrownType = m.getThrownTypes();

          temp.params = m.getParameters();
          temp.params.add(newPara);
        }
      }
      Substitution.insertAll(ctClass, temp);
    }
  }
}

class ParaTemp extends ExtensionTemplate {
  public void mName(Object params) {
     body.S();
  }

  @Parameter
  public List<CtParameter> params;
  @Parameter
  public String mName;
  @Parameter
  public CtBlock body;
  @Parameter
  public Set<CtTypeReference> thrownType;
  @Parameter
  public CtTypeReference type;
}
