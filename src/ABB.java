public class ABB {
    private Citizen root;

    public Citizen getRoot() {
        return root;
    }

    public void setRoot(Citizen root) {
        this.root = root;
    }
    public void insert(String id, String fullName, String birthDate, String cityOfBirth){
        Citizen node = new Citizen(id,fullName,birthDate,cityOfBirth);
        if(root == null){
            root = node;
        }else{
            insert(node, root);
        }
        System.out.println("A citizen has been added!");
    }
    private void insert(Citizen node, Citizen current){
        if(node.getId().compareTo(current.getId()) < 0){
            if(current.getLeft() == null){
                current.setLeft(node);
                return;
            }else {
                insert(node, current.getLeft());
                return;
            }
        }else if(node.getId().compareTo(current.getId()) > 0){
            if(current.getRight() == null){
                current.setRight(node);
                return;
            }else {
                insert(node, current.getRight());
                return;
            }
        }else{
            //Como las cedulas son unicas tonces no hay caso de igualdad
        }
    }
    public void search(String id){
        if(root!=null) {
            Citizen citizen=search(id,root,0);
            String msg1 = (citizen==null) ? "The citizen was not found" : citizen.toString();
            System.out.println(msg1);
        }else{
            System.out.println("There is no citizens");
        }
    }
    private Citizen search(String id, Citizen current, int iter){
        if(current == null){
            return null;
        }
        if(id.compareTo(current.getId()) == 0){
            System.out.println("***************************\n" +
                    "Found in "+iter+" iterations");
            return current;
        }
        else if(id.compareTo(current.getId()) < 0){
            return search(id, current.getLeft(),iter+1);
        } else{
            return search(id, current.getRight(),iter+1);
        }
    }
    public void delete(String id){
        if(root!=null) {
            delete(id, root);
        }else{
            System.out.println("There is no citizens");
        }
    }

    private Citizen delete(String id, Citizen current){
        if(current == null){
            return null;
        }
        if(id.compareTo(current.getId()) == 0){
            //1. Nodo Hoja
            if(current.getLeft() == null && current.getRight() == null){
                if(current == root){
                    root = null;
                }else{

                }
                return null;
            }
            //2. Nodo solo hijo izquierdo
            else if (current.getRight() == null){
                if(current == root){
                    root = current.getLeft();
                }
                return current.getLeft();
            }
            //3. Nodo solo hijo derecho
            else if(current.getLeft() == null){
                if(current == root){
                    root = current.getRight();
                }
                return current.getRight();
            }
            //4. Nodo con dos hijos
            else{
                Citizen min = getMin(current.getRight());
                //Transferencia de valores, NUNCA de conexiones
                current.setId(min.getId());
                current.setFullName(min.getFullName());
                current.setBirthDate(min.getBirthDate());
                current.setCityOfBirth(min.getCityOfBirth());
                //Hacer eliminación a partir de la derecha
                Citizen subarbolDER = delete(min.getId(), current.getRight());
                current.setRight( subarbolDER );
                return current;
            }


        }else if(id.compareTo(current.getId()) < 0){
            Citizen subArbolIzquierdo = delete(id, current.getLeft());
            current.setLeft(subArbolIzquierdo);
            return current;
        }else{
            Citizen subArbolDerecho = delete(id, current.getRight());
            current.setRight(subArbolDerecho);
            return current;
        }
    }
    public Citizen getMin(Citizen current){
        if(current.getLeft() == null){
            return current;
        }
        return getMin(current.getLeft());
    }
    public void inorder(){
        inorder(root);
    }

    private void inorder(Citizen current){
        if(current == null){
            return;
        }
        inorder(current.getLeft());
        System.out.println(current.getId());
        inorder(current.getRight());
    }
}
