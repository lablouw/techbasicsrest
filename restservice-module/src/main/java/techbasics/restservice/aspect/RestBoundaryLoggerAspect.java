package techbasics.restservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StringUtils;

@Aspect
@Slf4j
public class RestBoundaryLoggerAspect {
    @Around("execution(public * techbasics.restservice.domain.service.*.*.*(..))")
    public Object logRestApiCall(ProceedingJoinPoint pjp) throws Throwable {
        String argsPattern = "";
        for (int i = 0; i < pjp.getArgs().length; i++) {
            argsPattern += "{}, ";
        }
        argsPattern = StringUtils.isEmpty(argsPattern) ? argsPattern : argsPattern.substring(0, argsPattern.length() - 2);

        String method = pjp.getSignature().getName();

        log.info("Inbound: [method={}, args=" + argsPattern + "]", method, pjp.getArgs());
        Object ret = pjp.proceed();
        log.info("Outbound: [method={}, response={}]", method, ret);
        return ret;

    }
}
