package spoon.test.template;

import jdk.nashorn.internal.objects.annotations.Getter;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtFieldAccess;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtTypeReference;
import spoon.template.AbstractTemplate;
import spoon.template.Local;
import spoon.template.Parameter;

/**
 * Created by urli on 13/02/2017.
 */
public class GetterInvocationTemplate<_FieldType_> extends AbstractTemplate {

    @Parameter
    CtTypeReference<?> _FieldType_;

    @Parameter("_field_")
    String __field_;

    @Parameter
    String _Field_;

    @Parameter
    CtExpression<GetterInvocationTemplate> _target_;

    @Parameter
    CtFieldAccess fieldReference;

    @SuppressWarnings("unchecked")
    @Local
    public GetterInvocationTemplate(CtTypeReference<?> type, String field,
                                    CtFieldAccess fieldReference) {
        _FieldType_ = type;
        __field_ = field;
        _Field_ = field.substring(0,1).toUpperCase() + field.substring(1);
        _target_ = (CtExpression) fieldReference.getTarget();
        this.fieldReference = fieldReference;
    }

    @Local
    _FieldType_ _field_;

    @Getter
    public _FieldType_ get_Field_() {
        return _field_;
    }

    void getterInvocation() {
        _target_.S().get_Field_();
    }

    @Override
    public CtElement apply(CtType arg0) {
        // TODO Auto-generated method stub
        return null;
    }
}
