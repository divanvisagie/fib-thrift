namespace java com.example.math.thriftjava
#@namespace scala com.example.math.thriftscala
namespace rb Math

include "finatra-thrift/finatra_thrift_exceptions.thrift"

service MathService {

    i32 fibonacci(i32 count) throws (
        1: finatra_thrift_exceptions.ClientError clientError,
        2: finatra_thrift_exceptions.ServerError serverError
    )
}