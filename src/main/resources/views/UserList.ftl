<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User List</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
  </head>
 <body>
   <header>
        <nav class="navbar navbar-default">
          <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Library System</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav">
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manage Users</a>
                  <ul class="dropdown-menu">
                    <li data-toggle="modal" data-target="#addUserModal"><a href="#">Add a User</a></li>
                    <li><a href="/users">User List</a></li>
                    <li data-toggle="modal" data-target="#editUserModal"><a href="#">Edit a User</a></li>
                  </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manage Books</a>
                      <ul class="dropdown-menu">
                        <li data-toggle="modal" data-target="#addBookModal"><a href="#">Add a Book</a></li>
                        <li><a href="/books">Book List</a></li>
                        <li data-toggle="modal" data-target="#findBookModal"><a href="#">Find a Book</a></li>
                      </ul>
                </li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li data-toggle="modal" data-target="#checkOutBookModal"><a href="#">Check Out a Book</a></li>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Add a User</h4>
              </div>
              <div class="modal-body">
                    <form class="form-horizontal" action="/users" method="POST">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">First Name*</label>
                            <div class="col-sm-8">
                              <input type="text" class="form-control" id="inputEmail3" placeholder="First Name" name="first_name" pattern="[A-Za-z]+" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Middle Name</label>
                            <div class="col-sm-8">
                              <input type="text" class="form-control" id="inputEmail3" placeholder="Middle Name" name="middle_name" pattern="[A-Za-z]*">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Last Name*</label>
                            <div class="col-sm-8">
                              <input type="text" class="form-control" id="inputEmail3" placeholder="Last Name" name="last_name" pattern="[A-Za-z]+" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Age*</label>
                            <div class="col-sm-8">
                              <input type="number" class="form-control" id="inputEmail3" placeholder="Age" name="age" min="1" pattern="[0-9]{2}" required>
							  <span class="help-block">Enter positive number.</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Gender* </label>
                            <div class="col-sm-8">
                              <input type="text" class="form-control" id="inputEmail3" placeholder="Gender" name="gender" pattern="[M,F]{1}" required>
							  <span class="help-block">Enter F/M.</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Phone*</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="inputEmail3" placeholder="Phone Number" name="phone" pattern="[0-9]{10}" required>
                                <span class="help-block">Enter a <i>ten</i> digit phone number.</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Zip</label>
                            <div class="col-sm-8">
                              <input type="text" class="form-control" id="inputEmail3" placeholder="Zip" name="zip">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary col-md-2 col-md-offset-5">Submit</button><br><br>
                    </form>
              </div>
              <div class="modal-footer">
              </div>
            </div>
          </div>
        </div>
        <div class="modal fade" id="editUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Edit a User</h4>
              </div>
              <div class="modal-body">
                    <form class="form-horizontal" action="/users/:id" method="POST">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">User ID</label>
                            <div class="col-sm-8">
                              <input type="number" class="form-control" id="inputEmail3" placeholder="User ID" name="id" required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary col-md-2 col-md-offset-5">Submit</button><br><br>
                    </form>
              </div>
              <div class="modal-footer">
              </div>
            </div>
          </div>
        </div>
         <div class="modal fade" id="addBookModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Add a Book</h4>
              </div>
              <div class="modal-body">
                    <form class="form-horizontal" action="/books" method="POST">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Book Name*</label>
                            <div class="col-sm-8">
                              <input type="text" class="form-control" id="inputEmail3" placeholder="Book Name" name="name" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Authors*</label>
                            <div class="col-sm-8">
                              <input type="text" class="form-control" id="inputEmail3" placeholder="Enter Authors" name="authors" required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary col-md-2 col-md-offset-5">Submit</button><br><br>
                    </form>
              </div>
              <div class="modal-footer">
              </div>
            </div>
          </div>
        </div>
        <div class="modal fade" id="findBookModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Find a Book</h4>
              </div>
              <div class="modal-body">
                    <form class="form-horizontal" action="/books/:name" method="POST">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Book Name</label>
                            <div class="col-sm-8">
                              <input type="text" class="form-control" id="inputEmail3" placeholder="Book Name" name="name" required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary col-md-2 col-md-offset-5">Submit</button><br><br>
                    </form>
              </div>
              <div class="modal-footer">
              </div>
            </div>
          </div>
        </div>
		<div class="modal fade" id="checkOutBookModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Check Out Book</h4>
              </div>
              <div class="modal-body">
                    <form class="form-horizontal" action="/checkedOut" method="POST">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Enter Book ID*</label>
                            <div class="col-sm-8">
                              <input type="number" class="form-control" id="inputEmail3" name="book_id" placeholder="Book ID" required>
                            </div>
                        </div>
						<div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Enter User ID*</label>
                            <div class="col-sm-8">
                              <input type="number" class="form-control" id="inputEmail3" name="user_id" placeholder="User ID" required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary col-md-2 col-md-offset-5">Submit</button><br><br>
                    </form>
              </div>
              <div class="modal-footer">
              </div>
            </div>
          </div>
        </div>
    </header>
	<div class="table-responsive">
		<table class="table">
			 <tr>
				<th>User ID</th>
				<th>First Name</th>
				<th>Middle Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Phone Number</th>
				<th>Zip</th>
			 </tr>
			<#list userList as user>
				<tr>
					<td>${user.id}</td>
					<td>${user.firstName}</td>
					<td>${user.middleName}</td>
					<td>${user.lastName}</td>
					<td>${user.age}</td>
					<td>${user.gender}</td>
					<td>${user.phone}</td>
					<td>${user.zip}</td>
				</tr>
			</#list>   
		</table>
	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
  </body>
</html>