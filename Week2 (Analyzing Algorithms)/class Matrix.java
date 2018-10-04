class Matrix extends Table {

  public Matrix(int n, int m, int val) {
    super(n, m, val);
  }
  
  // pre: this and that have the same dimensions (n,m)
  // post: returns if pre a Matrix with dimension (n,m) 
  //       containing the sum of the elements of this and that, 
  //       returns otherwise null
  // +sum(Matrix that) : Matrix
  public Matrix sum(Matrix that) {
    if((this.numRows() == that.numRows()) && (this.numCols() == that.numCols())) {
      Matrix res = new Matrix(numRows(), numCols(), 0);
      for(int i = 0; i < this.numRows(); i++) {
        for(int j = 0; j < this.numCols(); j++) {
          int val = this.get(i,j) + that.get(i,j);
          res.set(i,j,val);
        }
      }
      return res;
    }
    return null;
  }

  // pre: this has dimension (n,m), that has dimension (m,p)
  // post: returns if pre a Matrix with dimension (n,p) 
  //       containing the product (of the elements) of each row of this and each column of that,
  //       returns otherwise null
  // +product(Matrix that) : Matrix
  public Matrix product(Matrix that) {
    if(this.numCols() == that.numRows()) {
     Matrix res = new Matrix(this.numRows(),that.numCols(),0);
     for(int i=0; i<this.numRows(); i++) {
       for(int j=0; j<that.numCols(); j++) {
         int val = 0;
         for(int k=0; k < that.numRows(); k++) {
           val += this.get(i,k) * that.get(k,j);
         }
         res.set(i,j,val);
       }
     }
     return res;
    }
    return null;
  }

}//
