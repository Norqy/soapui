package com.eviware.soapui.impl.wsdl.submit.filters;

import com.eviware.soapui.impl.rest.OAuth2Profile;
import com.eviware.soapui.impl.rest.OAuth2ProfileContainer;
import com.eviware.soapui.impl.rest.RestRequestInterface;
import com.eviware.soapui.impl.rest.actions.oauth.OAuth2ClientFacade;
import com.eviware.soapui.impl.rest.actions.oauth.OltuOAuth2ClientFacade;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.submit.transports.http.BaseHttpRequestTransport;
import com.eviware.soapui.model.iface.SubmitContext;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.types.StringToStringsMap;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.oltu.oauth2.common.OAuth;

public class OAuth2RequestFilter extends AbstractRequestFilter
{
	@Override
	public void filterRestRequest( SubmitContext context, RestRequestInterface request )
	{
		HttpRequestBase httpMethod = ( HttpRequestBase )context.getProperty( BaseHttpRequestTransport.HTTP_METHOD );

		WsdlProject project = request.getResource().getService().getProject();
		OAuth2ProfileContainer profileContainer = project.getOAuth2ProfileContainer();

		if( !profileContainer.getOAuth2ProfileList().isEmpty() )
		{
			OAuth2Profile profile = profileContainer.getOAuth2ProfileList().get( 0 );
			if( StringUtils.isNullOrEmpty( profile.getAccessToken()))
			{
				return;
			}
			OAuth2ClientFacade oAuth2Client = new OltuOAuth2ClientFacade();
			oAuth2Client.applyAccessToken( profile, httpMethod, request.getRequestContent() );
		}



	}

}
