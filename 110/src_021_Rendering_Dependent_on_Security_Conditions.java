<h:commandButton value="Delete" 
      action="#{bean.delete}" 
      rendered="#{request.isUserInRole('admin')}" />
