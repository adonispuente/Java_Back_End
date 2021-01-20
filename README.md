# Back_End

This is a Java BackEnd that allows for complete CRUD opperations for this plant database. A user is able to edit, add, delete, and update any plant in the database with the data persisting and updating quickly.


Pathways
GET
/users - List All Users
/myinfo - gets an authenticated users info through their unique token
/plants - list every plant in the database

DELETE
/user/{id} - Deletes a specific user
/plants/{plantid} - deletesUsesPlant by Plant Id

POST
/plants/{userid} - adds new plant to a specific user
/createnewuser - Makes a new User in the database

Put
/user/{userid} - updates the entire user
/user/plants - updates a specific users plant

-------------
/oauth/revoke-token, "/logout" - Revokes a users token so they can no longer access the cite without relogging in


