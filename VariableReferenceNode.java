public class VariableReferenceNode extends StatementNode{
    
    private String name;
    private Node arrayIndexExpression = null;
    private VariableNode referencedVariableNode = null;
    private VariableNode.variableType type = null;

    public VariableReferenceNode(String inputName, VariableNode inputReferencedNode) {
        name = inputName;
        referencedVariableNode = inputReferencedNode;
        type = inputReferencedNode.getType();
    }

    public VariableReferenceNode(String inputName, Node inputArrayIndexExpression, VariableNode inputReferencedNode) {
        name = inputName;
        arrayIndexExpression = inputArrayIndexExpression;
        referencedVariableNode = inputReferencedNode;
        type = inputReferencedNode.getArrayType();
    }

    public String getName() {
        return name;
    }

    public Node getIndex() {
        if (arrayIndexExpression instanceof IntegerNode) {
            IntegerNode intNodeIndex = (IntegerNode) arrayIndexExpression;
            return intNodeIndex;
        }
        else if (arrayIndexExpression instanceof MathOpNode) {
            MathOpNode mathOpNodeIndex = (MathOpNode) arrayIndexExpression;
            return mathOpNodeIndex;
        }
        else if (arrayIndexExpression instanceof VariableReferenceNode) {
            VariableReferenceNode newVariableReferenceNode = (VariableReferenceNode) arrayIndexExpression;
            return newVariableReferenceNode;
        }
        return null;
    }

    public VariableNode.variableType getType() {
        return type;
    }

    public VariableNode getReferencedVariable() {
        return referencedVariableNode;
    }

    public void setIndex(IntegerNode inputIntegerNode) {
        arrayIndexExpression = inputIntegerNode;
    }

    public String ToString() {
        String str = "VariableReferenceNode(Name:" + name;
        // Will call the ToString method for all nested expressions within array index
        if (arrayIndexExpression instanceof VariableReferenceNode) {
            VariableReferenceNode innerExpression = (VariableReferenceNode) arrayIndexExpression;
            str += ", Index: " + innerExpression.ToString();
        }
        else if (arrayIndexExpression instanceof IntegerNode) {
            IntegerNode innerExpression = (IntegerNode) arrayIndexExpression;
            str += ", Index: " + innerExpression.ToString();
        }
        else if (arrayIndexExpression instanceof RealNode) {
            RealNode innerExpression = (RealNode) arrayIndexExpression;
            str += ", Index: " + innerExpression.ToString();
        }
        else if (arrayIndexExpression instanceof MathOpNode) {
            MathOpNode innerExpression = (MathOpNode) arrayIndexExpression;
            str += ", Index: " + innerExpression.ToString();
        }
        else if (arrayIndexExpression instanceof BooleanCompareNode) {
            BooleanCompareNode innerExpression = (BooleanCompareNode) arrayIndexExpression;
            str += ", Index: " + innerExpression.ToString();
        }
        str += ")";
        return str;
    }
}
