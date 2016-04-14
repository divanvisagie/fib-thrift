/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

public enum ClientErrorCause
{
  /// <summary>
  /// Improperly-formatted request can't be fulfilled.
  /// </summary>
  BAD_REQUEST = 0,
  /// <summary>
  /// Required request authorization failed.
  /// </summary>
  UNAUTHORIZED = 1,
  /// <summary>
  /// Server timed out while fulfilling the request.
  /// </summary>
  REQUEST_TIMEOUT = 2,
  /// <summary>
  /// Initiating client has exceeded its maximum rate.
  /// </summary>
  RATE_LIMITED = 3,
}
