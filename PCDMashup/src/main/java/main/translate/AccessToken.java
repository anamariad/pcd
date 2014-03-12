package main.translate;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Annouk
 * The access token is valid for 10 minutes. 
 * If the access token expires, you need to generate a new access token.
 * 
 */
public class AccessToken implements Serializable {
	
	private String access_token;
	private String token_type;
	private String expires_in; // it's usually 10 mins
	private String scope;
	private Date issuedTime;
	
	
	/**
	 * @return the access_token
	 */
	public String getAccessToken() {
		return access_token;
	}
	/**
	 * @param access_token the access_token to set
	 */
	public void setAccessToken(String access_token) {
		this.access_token = access_token;
	}
	/**
	 * @return the token_type
	 */
	public String getTokenType() {
		return token_type;
	}
	/**
	 * @param token_type the token_type to set
	 */
	public void setTokenType(String token_type) {
		this.token_type = token_type;
	}
	/**
	 * @return the expires_in
	 */
	public String getExpirationPeriod() {
		return expires_in;
	}
	/**
	 * @param expires_in the expires_in to set
	 */
	public void setExpirationPeriod(String expires_in) {
		this.expires_in = expires_in;
	}
	/**
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}
	/**
	 * @param scope the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
	/**
	 * @return the issuedTime
	 */
	public Date getIssuedTime() {
		return issuedTime;
	}
	/**
	 * @param issuedTime the issuedTime to set
	 */
	public void setIssuedTime(Date issuedTime) {
		this.issuedTime = issuedTime;
	}


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccessToken{");
        sb.append("access_token='").append(access_token).append('\'');
        sb.append(", token_type='").append(token_type).append('\'');
        sb.append(", expires_in='").append(expires_in).append('\'');
        sb.append(", scope='").append(scope).append('\'');
        sb.append(", issuedTime=").append(issuedTime);
        sb.append('}');
        return sb.toString();
    }
}
	
