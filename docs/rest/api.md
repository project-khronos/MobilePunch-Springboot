# Swagger documentation for ProjectKhronos API

## HTTPS://straylense.space/projectkhronos

This Api is used as a backend database for a ProjectKhronos client
                  application.



**Version** v1














# APIs


<table>
  <thead>
    <tr>
      <th>Path</th>
      <th>Method</th>
      <th>Summary</th>
    </tr>
  </thead>
  <tbody>
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/clients</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Get the List of Clients</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#postClient">Post a Client</a></td></tr>
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/clients/{clientId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getClient">Get a Client.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#deleteClient">Delete a client</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/clients/{clientId}/projects</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getProjects">List of Projects</a></td></tr>
        
        
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/equipment</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Get equipment list</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#postEquipment">Post Equipment</a></td></tr>
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/equipment/{equipmentId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getEquipment">Get Equipment</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#deleteEquipment">Delete equipoment</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/events/{eventId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getEvent">Get an Event</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#deleteEvent">Delete an Event</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/events/{eventId}/equipment</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#equipment">Get Event Equipment</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#postEventEquipment">Post Event Equipment</a></td></tr>
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/projects</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Get Projects</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#postProject">Post a Project</a></td></tr>
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/projects/{projectId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getProject">Get a Project</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#deleteProject">Delete Project</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/projects/{projectId}/clients</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getClients">Get Project Client</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#postClient">Post a Client to a Project</a></td></tr>
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/projects/{projectId}/events</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getEvents">Get Project Events</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#postEvent"></a></td></tr>
        
        
        
        
      
    
  </tbody>
</table>


## /clients



### <a name="list"></a>GET

Get the List of Clients

Returns the list Clients associated with the user.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/ClientEntity">ClientEntity</a>]|






### <a name="postClient"></a>POST

Post a Client

Posts a Client entity to the api taking into account the user to whom the client record belongs to.







#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>yes</td>
    <td>Partial Client definition</td>
    <td></td>

    <td>
    
    <a href="#/definitions/ClientEntity">ClientEntity</a> 
    </td>

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/ClientEntity">ClientEntity</a>|









<a name=""></a>



## /clients/{clientId}



### <a name="getClient"></a>GET

Get a Client.

Returns a single Client.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>clientId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Client Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/ClientEntity">ClientEntity</a>|








### <a name="deleteClient"></a>DELETE

Delete a client

Delete a specified Client.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>clientId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Client Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    |  |  - |







<a name=""></a>



## /clients/{clientId}/projects



### <a name="getProjects"></a>GET

List of Projects

Returns a list of Projects associated with a the specified Client.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>clientId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Client Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/ProjectEntity">ProjectEntity</a>]|













<a name=""></a>



## /equipment



### <a name="list"></a>GET

Get equipment list

Returns thew list of all equipment associated with the user.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/EquipmentEntity">EquipmentEntity</a>]|






### <a name="postEquipment"></a>POST

Post Equipment

Post an Equipment entity to the API.







#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>yes</td>
    <td>Partial equipment definition</td>
    <td></td>

    <td>
    
    <a href="#/definitions/EquipmentEntity">EquipmentEntity</a> 
    </td>

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/EquipmentEntity">EquipmentEntity</a>|









<a name=""></a>



## /equipment/{equipmentId}



### <a name="getEquipment"></a>GET

Get Equipment

Returns a single equipment entity







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>equipmentId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Equipment Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/EquipmentEntity">EquipmentEntity</a>|








### <a name="deleteEquipment"></a>DELETE

Delete equipoment

Deletes a single Equipment entity.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>equipmentId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Equipment ID</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    |  |  - |







<a name=""></a>



## /events/{eventId}



### <a name="getEvent"></a>GET

Get an Event

Returns a single Event







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>eventId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Event Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/EventEntity">EventEntity</a>|








### <a name="deleteEvent"></a>DELETE

Delete an Event

Deletes an Event without deleting the project associated with the Event.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>eventId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Event Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    |  |  - |







<a name=""></a>



## /events/{eventId}/equipment



### <a name="equipment"></a>GET

Get Event Equipment

Returns the Equipment associated with a single event.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>eventId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Event Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/EquipmentEntity">EquipmentEntity</a>|






### <a name="postEventEquipment"></a>POST

Post Event Equipment

Associates an Equipment entity with a single Event.







#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>eventId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Event Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>

<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/EquipmentEntity">EquipmentEntity</a> 
    </td>

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/EventEntity">EventEntity</a>|









<a name=""></a>



## /projects



### <a name="list"></a>GET

Get Projects

Returns a list of Projects associated to the user.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/ProjectEntity">ProjectEntity</a>]|






### <a name="postProject"></a>POST

Post a Project

Posts a Project entity to the api taking into account the user to whom the Project record belongs to







#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>yes</td>
    <td>Partial Project Definition</td>
    <td></td>

    <td>
    
    <a href="#/definitions/ProjectEntity">ProjectEntity</a> 
    </td>

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/ProjectEntity">ProjectEntity</a>|









<a name=""></a>



## /projects/{projectId}



### <a name="getProject"></a>GET

Get a Project

Returns a single Project. 







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>projectId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Project Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/ProjectEntity">ProjectEntity</a>|








### <a name="deleteProject"></a>DELETE

Delete Project

Delete a Project and its Events.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>projectId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Project Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    |  |  - |







<a name=""></a>



## /projects/{projectId}/clients



### <a name="getClients"></a>GET

Get Project Client

Returns the Client associated with the Project.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>projectId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Project Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/ClientEntity">ClientEntity</a>|






### <a name="postClient"></a>POST

Post a Client to a Project

Associates a single Client to a single Project.







#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>projectId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Project Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>

<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>yes</td>
    <td>Client Id</td>
    <td></td>

    <td>
    
    <a href="#/definitions/ClientEntity">ClientEntity</a> 
    </td>

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/ProjectEntity">ProjectEntity</a>|









<a name=""></a>



## /projects/{projectId}/events



### <a name="getEvents"></a>GET

Get Project Events

Returns the list of Events associated with a single Project.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>projectId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Project Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/EventEntity">EventEntity</a>]|






### <a name="postEvent"></a>POST











#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>projectId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td>Project Id</td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>

<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>yes</td>
    <td>Partial Event definition</td>
    <td></td>

    <td>
    
    <a href="#/definitions/EventEntity">EventEntity</a> 
    </td>

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/EventEntity">EventEntity</a>|









<a name=""></a>




# Definitions

## <a name="/definitions/ClientEntity">ClientEntity</a>

<table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Mode</th>
        <th>Description</th>
        <!--<th>Example</th>-->
    </tr>
    
        <tr>
            <td><strong>uuid</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              required
            </td>
            <td>Client Id</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>name</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>phone</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>altPhone</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>email</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>address</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>altAddress</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>notes</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>projects</strong></td>
            <td>
                
                
                    array[<a href="#/definitions/ProjectEntity">ProjectEntity</a>]
                
                
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>href</strong></td>
            <td>
                
                    
                    string (uri)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
</table>

## <a name="/definitions/EquipmentEntity">EquipmentEntity</a>

<table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Mode</th>
        <th>Description</th>
        <!--<th>Example</th>-->
    </tr>
    
        <tr>
            <td><strong>uuid</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              required
            </td>
            <td>Equipment Id</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>name</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>identification</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>make</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>model</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>mfcyear</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>description</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>events</strong></td>
            <td>
                
                
                    array[<a href="#/definitions/EventEntity">EventEntity</a>]
                
                
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>href</strong></td>
            <td>
                
                    
                    string (uri)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>year</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
</table>

## <a name="/definitions/EventEntity">EventEntity</a>

<table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Mode</th>
        <th>Description</th>
        <!--<th>Example</th>-->
    </tr>
    
        <tr>
            <td><strong>startTime</strong></td>
            <td>
                
                    
                    string (date-time)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>endTime</strong></td>
            <td>
                
                    
                    string (date-time)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>expenses</strong></td>
            <td>
                
                    
                    number
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>income</strong></td>
            <td>
                
                    
                    number
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>description</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>latitude</strong></td>
            <td>
                
                    
                    number (double)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>longitude</strong></td>
            <td>
                
                    
                    number (double)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>project</strong></td>
            <td>
                
                    <a href="#/definitions/ProjectEntity">ProjectEntity</a>
                    
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>equipment</strong></td>
            <td>
                
                    <a href="#/definitions/EquipmentEntity">EquipmentEntity</a>
                    
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>href</strong></td>
            <td>
                
                    
                    string (uri)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>event_id</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              required
            </td>
            <td>Event ID</td>
            <!--<td></td>-->
        </tr>
    
</table>

## <a name="/definitions/ProjectEntity">ProjectEntity</a>

<table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Mode</th>
        <th>Description</th>
        <!--<th>Example</th>-->
    </tr>
    
        <tr>
            <td><strong>uuid</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              required
            </td>
            <td>Project Id</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>name</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>startTime</strong></td>
            <td>
                
                    
                    string (date-time)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>endTime</strong></td>
            <td>
                
                    
                    string (date-time)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>expectedEndTime</strong></td>
            <td>
                
                    
                    string (date-time)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>description</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>client</strong></td>
            <td>
                
                    <a href="#/definitions/ClientEntity">ClientEntity</a>
                    
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>events</strong></td>
            <td>
                
                
                    array[<a href="#/definitions/EventEntity">EventEntity</a>]
                
                
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>href</strong></td>
            <td>
                
                    
                    string (uri)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
</table>
